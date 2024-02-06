import axios from "axios";
import React, { useState, ChangeEvent, FormEvent } from "react";
import { Button, Form } from "react-bootstrap";

interface Item {
  memo?: string;
}

interface InsertItemProps {
  // Add any props if needed
}

function InsertItem(props: InsertItemProps) {
  const [item, setItem] = useState<Item>({});

  const insertItem = (e: FormEvent) => {
    e.preventDefault(); // Prevent the default form submission

    axios({
      method: "post",
      url: "/test/post",
      data: item,
    })
      .then((res) => {
        alert("등록 완료");
        window.location.replace("/");
      })
      .catch((err) => {
        alert("error!");
      });
  };

  const inputChangeHandler = (e: ChangeEvent<HTMLInputElement>) => {
    var newItem: Item = { ...item, [e.target.name]: e.target.value };
    setItem(newItem);
  };

  return (
    <div>
      <Form onSubmit={insertItem}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Control
            type="text"
            placeholder="memo"
            name="memo"
            onChange={inputChangeHandler}
          />
        </Form.Group>

        <Button variant="primary" type="submit">
          등록하기
        </Button>
      </Form>
    </div>
  );
}

export default InsertItem;
