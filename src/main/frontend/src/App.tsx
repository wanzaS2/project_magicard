import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import InsertMemo from "./component/InsertMemo";
import MemoList from "./component/MemoList";
import OnboardingVideo from "./component_sg/OnboardingVideo";
import CardApplicationForm from "component_sg/IssueCard";
import Welcome from "component_sg/Welcome";

function App() {
  return (
    <>
      <BrowserRouter>
        {/* <InsertMemo /> 
        <hr />
        */}
        <Routes>
          <Route path="/" element={<MemoList />} />
          <Route path="card-application" element={<CardApplicationForm />} />
          <Route path="onboarding-video" element={<OnboardingVideo />} />
          <Route path="welcome" element={<Welcome />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
