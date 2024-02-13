import React, { useState, useEffect, useRef } from "react";
import "./ModalBasic.css";
import { Button } from "react-bootstrap";
import Select from "./Select";
import Input from "./Input";
import axios from "axios";

interface ModalBasicProps {
  setModalOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

function ModalBasic({ setModalOpen }: ModalBasicProps) {
  const [inputValues, setInputValues] = useState<{ [key: string]: string }>({});
  const [selectValue, setSelectValue] = useState("");
  const [purList, setPurList] = useState<{ purposeCategory: string }[]>([]);
  const [selectedCategory, setSelectedCategory] = useState("");

  const modalRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    loadListData(); // 컴포넌트가 마운트될 때 리스트를 가져옴
  }, []);

  const getResult = (obj: { [key: string]: string }) => {
    setInputValues({ ...inputValues, ...obj });
  };

  const handleFormSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log("Form submitted!");
    console.log("Input values:", inputValues);
    console.log("Select value:", selectValue);

    // 서버로 데이터를 전송
    axios({
      method: "post",
      url: "/pur/insert.do",
      data: {
        purposeCategory: inputValues.purposeCategory || selectedCategory,
        purposeItem: inputValues.purposeItem,
        // 필요한 경우 다른 데이터도 추가
      },
    })
      .then((res) => {
        console.log("대 소 insert 성공!!!!!!!!!!");

        console.log(res.data + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        if (res.data === 0) alert("값이 중복되었습니다.");
        else {
          alert("성공");
        }
      })
      .catch((err) => {
        console.log(err);
        // 오류 발생 시 처리
      });
  };

  const closeModal = () => {
    setModalOpen(false);
    loadListData(); // 모달을 닫을 때 리스트를 다시 가져옴
  };

  const loadListData = () => {
    axios({
      method: "get",
      url: "/pur/catelist.do",
    })
      .then((res) => {
        console.log("List 데이터 로드 성공");
        setPurList(res.data);
      })
      .catch((err) => {
        console.log("List 데이터 로드 실패");
      });
  };

  return (
    <div ref={modalRef} className="container">
      <button className="close" onClick={closeModal}>
        X
      </button>
      <p>모달창입니다.</p>
      <form onSubmit={handleFormSubmit}>
        <Select
          propsname="selectCategory"
          purList={purList}
          initialValue={selectValue}
          setSelectValue={setSelectValue}
          setSelectedValue={setSelectedCategory}
          setInputValues={setInputValues}
          inputValues={{}}
        />
        <Input
          propsname="purposeCategory"
          getResult={getResult}
          initialValue={selectedCategory}
        />
        <Input propsname="purposeItem" getResult={getResult} />
        <Button type="submit">등록하기</Button>
      </form>
    </div>
  );
}

export default ModalBasic;
