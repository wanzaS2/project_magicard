import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import InsertMemo from "component/InsertMemo";
import MemoList from "component/MemoList";

function App() {
  return (
    <>
      <BrowserRouter>
        <InsertMemo></InsertMemo>
        <hr></hr>
        <Routes>
          <Route path="/" element={<MemoList></MemoList>}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
