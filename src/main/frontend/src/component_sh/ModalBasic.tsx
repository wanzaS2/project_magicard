import { useEffect, useRef, useState } from "react";
import "./ModalBasic.css";
import { Button, Col, Form, Row } from "react-bootstrap";
import Select from "./Select";
import Input from "./Input";
import axios from "axios";

interface Purpose {
  purposeCategory: string;
}

interface ModalBasicProps {
  setModalOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

function ModalBasic({ setModalOpen }: ModalBasicProps) {
  //대분류 목록
  const [purList, setPurList] = useState<Purpose[]>([]);

  // 모달 끄기 (X버튼 onClick 이벤트 핸들러)
  const closeModal = () => {
    setModalOpen(false);
  };

  // 모달 외부 클릭시 끄기 처리
  // Modal 창을 useRef로 취득
  const modalRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    // 이벤트 핸들러 함수
    const handler = (event: MouseEvent) => {
      // mousedown 이벤트가 발생한 영역이 모달창이 아닐 때, 모달창 제거 처리
      if (
        modalRef.current &&
        !modalRef.current.contains(event.target as Node)
      ) {
        setModalOpen(false);
      }
    };

    // 이벤트 핸들러 등록
    document.addEventListener("mousedown", handler);

    return () => {
      // 이벤트 핸들러 해제
      document.removeEventListener("mousedown", handler);
    };
  }, [setModalOpen]); // 의존성 배열에 setModalOpen 추가

  useEffect(() => {
    axios({
      method: "get",
      url: "/pur/catelist.do",
    })
      .then((res) => {
        console.log(res.data);
        console.log("Modal check box list성공 성공 성공 성공 성공 성공");
        setPurList(res.data);
      })
      .catch((err) => {
        console.log(err);
        console.log("Modal check box list실패 실패 실패 실패 실패 실패");
      });
  }, []);

  return (
    // 모달창을 useRef로 잡아준다.
    <div ref={modalRef} className="container">
      <button className="close" onClick={closeModal}>
        X
      </button>
      <p>모달창입니다.</p>
      <Form>
        <Form.Group as={Row} className="mb-3" controlId="Category">
          <Form.Label column sm="2">
            대분류
          </Form.Label>
          <Col sm="10">
            <input type="text" name="category1" defaultValue="여기에 1" />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mb-3" controlId="Category2">
          <Form.Label column sm="2">
            소분류
          </Form.Label>
          <Col sm="10">
            <input type="select-box" name="category2" defaultValue="여기에 2" />
          </Col>
        </Form.Group>
        <input
          className="btn btn-primary btn-register"
          type="submit"
          value="등록"
        />
      </Form>
      <form>
        <Select purList={purList} />
        <Input name="age"></Input>
        <Input name="birthday"></Input>
        <Button type="submit"></Button>
      </form>
    </div>
  );
}
export default ModalBasic;
