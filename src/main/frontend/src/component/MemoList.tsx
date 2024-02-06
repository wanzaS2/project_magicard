import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";

interface MemoItem {
  id: number;
  memo: string;
}

function MemoList(props: any) {
  const [memoList, setValueList] = useState<MemoItem[]>([]);

  const handleDelete = (id: number) => {
    axios({
      method: "delete",
      url: `/test/delete/${id}`, // Adjust the URL according to your server endpoint
    })
      .then((res) => {
        alert("삭제 완료");
        window.location.replace("/");
      })
      .catch((err) => {
        alert("삭제 실패");
        console.log(err);
      });
  };

  useEffect(() => {
    axios({
      method: "get",
      url: "/test/list",
    })
      .then((res) => {
        console.log(res.data);
        setValueList(res.data);
      })
      .catch((err) => {
        alert("error!");
      });
  }, []);

  return (
    <div>
      <h1>안녕하세요 정문경입니다</h1>
      <Table>
        <thead>
          <tr>
            <th>메모</th>
          </tr>
        </thead>
        <tbody>
          {memoList &&
            memoList.map((item, idx) => (
              <tr key={idx}>
                <td> {item.memo}</td>
                <td>
                  <Button
                    variant="primary"
                    type="button"
                    onClick={() => {
                      handleDelete(item.id);
                    }}
                  >
                    삭제
                  </Button>
                </td>
              </tr>
            ))}
        </tbody>
      </Table>
    </div>
  );
}

export default MemoList;
