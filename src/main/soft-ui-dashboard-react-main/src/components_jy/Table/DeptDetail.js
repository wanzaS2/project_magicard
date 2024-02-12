import axios from "axios";
import { useCallback, useEffect, useState } from "react";
import { Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function DeptDetail(props) {
  const { departmentId } = props;
  const [deptDetail, setDeptDetail] = useState({});
  const [deptManager, setDeptManager] = useState({});
  const navi = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios({
      method: "put",
      url: "/rest/empdept/update.do",
      data: emp,
    }).then((res) => {
      console.log(res.data === 0 ? "성공" : "실패");
      navi("/empdept/list");
    });
  };

  useEffect(() => {
    axios({
      method: "GET",
      url: `/rest/departments/detail/${departmentId}`,
    })
      .then((res) => {
        console.log(res.data);
        setDeptDetail(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [departmentId]);

  useEffect(() => {
    axios({
      method: "GET",
      url: `/rest/departments/detailmanager/${departmentId}`,
    })
      .then((res) => {
        console.log(res.data);
        if (`${departmentId}` == 1) {
          axios({
            method: "get",
            url: "/rest/departments/detailfirstmanager",
          })
            .then((res) => setDeptManager(res.data))
            .catch((err) => console.log(err));
        }
        setDeptManager(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [departmentId]);

  const changeHandler = useCallback(
    (e) => {
      setDeptDetail({ ...deptDetail, [e.target.name]: e.target.value });
    },
    [deptDetail]
  );

  return (
    <div>
      <div
        style={{ fontSize: "1.25rem", fontWeight: "bold", marginLeft: "1rem", color: "#2F4F4F" }}
      >
        부서 상세조회
      </div>
      <DeptDetailDisplay
        manager={deptManager}
        dept={deptDetail}
        changeHandler={changeHandler}
        handleSubmit={handleSubmit}
      ></DeptDetailDisplay>
    </div>
  );
}

function DeptDetailDisplay({ dept, changeHandler, handleSubmit, manager }) {
  return (
    <div style={{ margin: "1.5rem" }}>
      <Form onSubmit={handleSubmit} style={{ fontSize: "1rem" }}>
        <Form.Group as={Row} className="mb-3" controlId="superDepartment">
          <Form.Label column sm="1" style={{ fontWeight: "bold" }}>
            부문
          </Form.Label>
          <Col sm="8">
            <Form.Control
              type="text"
              defaultValue={dept.superDepartment || ""}
              name="superDepartment"
              plaintext
            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mb-3" controlId="superDepartmentId">
          <Form.Label column sm="1" style={{ fontWeight: "bold" }}>
            상위부서
          </Form.Label>
          <Col sm="8">
            <Form.Control
              type="text"
              defaultValue={manager.superDepartmentId || ""}
              name="superDepartmentId"
              onChange={changeHandler}
            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mb-3" controlId="departmentId">
          <Form.Label column sm="1" style={{ fontWeight: "bold" }}>
            부서
          </Form.Label>
          <Col sm="8">
            <Form.Control
              type="text"
              defaultValue={dept.departmentId || ""}
              name="departmentId"
              onChange={changeHandler}
            />
          </Col>
        </Form.Group>

        {/* <Form.Group as={Row} className="mb-3" controlId="firstName">
          <Form.Label column sm="1">
            firstName
          </Form.Label>
          <Col sm="8">
            <Form.Control
              type="text"
              defaultValue={emp.firstName || ""}
              name="firstName"
              onChange={changeHandler}
            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="mb-3" controlId="email">
          <Form.Label column sm="1">
            이메일
          </Form.Label>
          <Col sm="8">
            <Form.Control
              type="text"
              defaultValue={emp.email || ""}
              name="email"
              onChange={changeHandler}
            />
          </Col> 
        </Form.Group>*/}
        {/* <input className="btn btn-warning" type="submit" value="저장" />{" "}
       <Link to="/empdept/delete" state={{ employeeId: emp.employeeId }}> */}
        <div style={{ marginLeft: "6rem" }} className="detailbtn">
          <button type="button">저장</button>
          <button type="button">삭제</button>
        </div>
        {/* </Link> */}
      </Form>
    </div>
  );
}

export default DeptDetail;
