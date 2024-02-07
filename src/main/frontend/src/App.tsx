import React from "react";
import EmpMgt from "./pages_mk/EmpMgt";
import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<EmpMgt />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
