import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { Col, Form, Row } from "react-bootstrap";
import { useLocation, useNavigate } from "react-router";
import { Link } from "react-router-dom";
import Modal from "./Modal";

interface Purpose {
  purposeItem: string;
  purposeCategory: string;
}

function PurposeList(props: any) {
  const [purList, setPurList] = useState<Purpose[]>([]);
  const [newCategory, setNewCategory] = useState<string>("");
  const navi = useNavigate();
  const location = useLocation();
  // const uuid = location.state.uuid;

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setNewCategory(e.target.value);
  };

  const deleteCategory = () => {
    axios({
      method: "delete",
      url: `/pur/delete.do`,
    })
      .then((res) => {
        console.log("delete 성공 delete 성공 delete 성공");
      })
      .catch((err) => {
        console.log(err);
        console.log("delete 실패 delete 실패 delete 실패");
      });
  };

  const handleSubmit = () => {
    axios({
      method: "post",
      url: "/pur/insert.do",
      data: { purposeCategory: newCategory },
    })
      .then((res) => {
        console.log("insert 성공 insert 성공 insert 성공");
        const newPurList: Purpose[] = [...purList, res.data];
        setPurList(newPurList);
        navi("/pur/list");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    axios({
      method: "get",
      url: "/pur/list.do",
    })
      .then((res) => {
        console.log(res.data);
        console.log("성공 성공 성공 성공 성공 성공");
        setPurList(res.data);
      })
      .catch((err) => {
        console.log(err);
        console.log("실패 실패 실패 실패 실패 실패");
      });
  }, [newCategory]);

  return (
    <div>
      <h1> Category 목록</h1>
      <CategoryDisplay
        purList={purList}
        handleChange={handleChange}
        handleSubmit={handleSubmit}
        newCategory={newCategory}
        deleteCategory={deleteCategory}
      ></CategoryDisplay>
    </div>
  );
}

function CategoryDisplay({
  purList,
  handleChange,
  handleSubmit,
  newCategory,
  deleteCategory,
}: {
  purList: Purpose[];
  handleChange: any;
  handleSubmit: any;
  newCategory: string;
  deleteCategory: any;
}) {
  return (
    <>
      <h1> Category Display</h1>
      <Modal></Modal>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>대분류</th>
            <th>소분류</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {purList.map((pur, index) => (
            <tr key={index}>
              <td>{pur.purposeCategory}</td>
              <td>{pur.purposeItem}</td>
              <td>
                <Link to="" state={{ uuid: pur.purposeItem }}>
                  <Button>삭제</Button>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <h1> 데이터 입력 연습!!!!!!!!</h1>
      <Form>
        <Form.Group as={Row} className="mb-3" controlId="newCategory">
          <Form.Label column sm="2">
            Add New Category
          </Form.Label>
          <Col sm="10">
            <Form.Control
              type="text"
              placeholder="Enter category"
              value={newCategory}
              onChange={handleChange}
            />
          </Col>
        </Form.Group>
        <Button variant="primary" onClick={handleSubmit}>
          Add
        </Button>
      </Form>
    </>
  );
}

export default PurposeList;
