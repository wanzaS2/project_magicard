import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import InsertMemo from "./component/InsertMemo";
import MemoList from "./component/MemoList";
import DepartmentList from "./component_jy/DepartmentList";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/jy" element={<DepartmentList />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
