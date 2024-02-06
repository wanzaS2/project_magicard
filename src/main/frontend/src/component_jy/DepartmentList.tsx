import React from "react";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import "../static/css/css_jy/deptList.css";

function DepartmentList(props: any) {
  return (
    <div>
      <h1>DepartmentList ㅎㅎ</h1>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <Link to="/jy">
        <img className="insertDept" src="/static/image_jy/insertDept.png"></img>
      </Link>

      <Table>
        <thead>
          <tr>
            <th> 부서 </th>
            <th> 부서장 </th>
            <th> 총 인원 </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>디지털전략팀</td>
            <td>노승광</td>
            <td>20명</td>
          </tr>
          <tr>
            <td>ICT&정보보호전략팀</td>
            <td>신서영</td>
            <td>25명</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
}

export default DepartmentList;
