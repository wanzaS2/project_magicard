import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import Modal from "./Modal";

interface Purpose {
  purposeItem: string;
  purposeCategory: string;
}

function PurposeList(props: any) {
  const [purList, setPurList] = useState<Purpose[]>([]);
  const [newCategory, setNewCategory] = useState<string>("");
  const [isAscending, setIsAscending] = useState<boolean>(true); // 오름차순 여부 상태 추가

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

  // 대분류를 기준으로 오름차순 또는 내림차순으로 정렬하는 함수
  const sortListByCategory = () => {
    const sortedList = [...purList];
    sortedList.sort((a, b) => {
      if (isAscending) {
        return a.purposeCategory.localeCompare(b.purposeCategory);
      } else {
        return b.purposeCategory.localeCompare(a.purposeCategory);
      }
    });
    setPurList(sortedList);
    setIsAscending(!isAscending); // 정렬 방향을 반대로 변경
  };

  return (
    <div>
      <h1> Category 목록</h1>
      <CategoryDisplay
        purList={purList}
        handleChange={handleChange}
        newCategory={newCategory}
        deleteCategory={deleteCategory}
        sortListByCategory={sortListByCategory} // 대분류 정렬 함수 추가
      ></CategoryDisplay>
    </div>
  );
}

function CategoryDisplay({
  purList,
  handleChange,
  newCategory,
  deleteCategory,
  sortListByCategory,
}: {
  purList: Purpose[];
  handleChange: any;
  newCategory: string;
  deleteCategory: any;
  sortListByCategory: any;
}) {
  return (
    <>
      <h1> Category Display</h1>
      <Modal></Modal>
      {/* 새로운 버튼 추가 */}
      <Button onClick={sortListByCategory}>대분류 정렬</Button>
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
    </>
  );
}

export default PurposeList;
