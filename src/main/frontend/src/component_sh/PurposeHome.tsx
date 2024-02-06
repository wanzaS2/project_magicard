import React from "react";
import { Button } from "react-bootstrap";
import { Link, Route, Routes } from "react-router-dom";
import PurposeList from "./PurposeList";

function PurposeHome(props: any) {
  return (
    <div>
      <h1> PurposeHome </h1>
      <Link to="list">
        <Button>카테고리 조회</Button>
      </Link>

      <Routes>
        <Route path="/list" element={<PurposeList />} />
      </Routes>
    </div>
  );
}

export default PurposeHome;
