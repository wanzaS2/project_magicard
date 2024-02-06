import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import InsertMemo from "./component/InsertMemo";
import MemoList from "./component/MemoList";

function App() {
  return (
    <>
      <BrowserRouter>
        <InsertMemo />
        <hr />
        <Routes>
          <Route path="/" element={<MemoList />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
