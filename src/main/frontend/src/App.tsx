import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import InsertMemo from "./component/InsertMemo";
import MemoList from "./component/MemoList";
import PurposeHome from "./component_sh/PurposeHome";

function App() {
  return (
    <>
      <BrowserRouter>
        <InsertMemo />
        <hr />
        <Routes>
          <Route path="/" element={<MemoList />} />
          <Route path="/pur/*" element={<PurposeHome />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
