import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";

interface Purpose {
  purposeCategoryUid: number;
  purposeCategory: string;
}

function PurposeList(props: any) {
  const [purList, setPurList] = useState<Purpose[]>([]);

  useEffect(() => {
    axios({
      method: "post",
      url: "/pur/list.do",
      data: { companyTicker: "TEST1" },
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
  }, []); // 두 번째 매개변수로 빈 배열을 전달하여 한 번만 실행되도록 설정

  return (
    <div>
      <h1> Category 목록</h1>
      <CategoryDisplay purList={purList}></CategoryDisplay>
    </div>
  );
}

function CategoryDisplay({ purList }: { purList: Purpose[] }) {
  return (
    <>
      <h1> dddddddddddddddddddddddddddddddddddddddddd</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>category</th>
            <th>uuid</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {purList &&
            purList.map((pur, index) => (
              <tr key={index}>
                <td> {pur.purposeCategory}</td>
                <td> {pur.purposeCategoryUid}</td>
                <td></td>
              </tr>
            ))}
        </tbody>
      </Table>
    </>
  );
}

export default PurposeList;
