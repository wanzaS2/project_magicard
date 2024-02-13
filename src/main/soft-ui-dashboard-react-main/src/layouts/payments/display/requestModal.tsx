import React, { useEffect } from "react";
import { Modal } from "@mui/material";
import "./requestModal.css";
import axios from "axios";

const ModalContext = ({ isOpen, closeModal, selectedPaymentId }: any) => {
  if (!isOpen) return null;

  useEffect(() => {
    axios({
      method: "get",
      url: "/paymentInfo/getTotalAmount",
    })
      .then((result) => {
        console.log(result.data);
      })
      .catch((err) => {});
  }, []);

  return (
    <div className={isOpen ? "openModal pop" : "pop"}>
      <div className="modal-content">
        <h1>결재 요청</h1>
      </div>
    </div>
  );
};

export default ModalContext;
