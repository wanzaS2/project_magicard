import axios from "axios";
import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";

function InsertItem(props) {
  const [item, setItem] = useState({});

  const insertItem = (e) => {
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
        alert("error!", err);
      });
  };

  const inputChangeHandler = (e) => {
    var newItem = { ...item, [e.target.name]: e.target.value };
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
