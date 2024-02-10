// /**
// =========================================================
// * Soft UI Dashboard React - v4.0.1
// =========================================================

// * Product Page: https://www.creative-tim.com/product/soft-ui-dashboard-react
// * Copyright 2023 Creative Tim (https://www.creative-tim.com)

// Coded by www.creative-tim.com

//  =========================================================

// * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// */

// import React, { useState } from "react";
// import ReactDOM from "react-dom/client";
// import { BrowserRouter } from "react-router-dom";
// import App from "App";

// // Soft UI Dashboard React Context Provider
// import { SoftUIControllerProvider } from "context";
// import Modal from "layouts/authentication/components/Modal/Modal";

// const root = ReactDOM.createRoot(document.getElementById("root"));

// const [modalOpen, setModalOpen] = useState(false);
// const openModal = () => {
//   setModalOpen(true);
// };
// const modalClose = () => {
//   setModalOpen(false);
// };
// root.render(
//   <>
//     <button onClick={openModal}> 이것은 버튼 !!!!!</button>
//     <Modal open={modalOpen} close={modalClose} header="연습">
//       ㅎㅎㅎ연습한당
//     </Modal>
//     <BrowserRouter>
//       <SoftUIControllerProvider>
//         <App />
//       </SoftUIControllerProvider>
//     </BrowserRouter>
//   </>
// );

import { useState } from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import App from "./App";

import "assets/css/modal.css";
import Modal from "components_jy/Modal/Modal";
import { SoftUIControllerProvider } from "./context";

const AppWithModal = () => {
  const [modalOpen, setModalOpen] = useState(false);

  const openModal = () => {
    setModalOpen(true);
  };
  const modalClose = () => {
    setModalOpen(false);
  };

  return (
    <>
      <button className="modalbtn" onClick={openModal}>
        {" "}
        이것은 버튼 !!!!!
      </button>
      <Modal open={modalOpen} close={modalClose} header="연습"></Modal>
      <BrowserRouter>
        <SoftUIControllerProvider>
          <App />
        </SoftUIControllerProvider>
      </BrowserRouter>
    </>
  );
};

ReactDOM.render(<AppWithModal />, document.getElementById("root"));
