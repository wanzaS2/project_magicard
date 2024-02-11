import DashboardLayout from "examples/LayoutContainers/DashboardLayout";
import DashboardNavbar from "examples/Navbars/DashboardNavbar";

import "layouts/payments/index.css";
import { Link, Route, Routes } from "react-router-dom";
import PaymentsInfo from "./display/paymentsInfo";
import RequestAll from "./display/requestAll";
import RequestApprove from "./display/requestApprove";
import Refuse from "./display/refuse";

function PaymentsTables() {
  return (
    <DashboardLayout>
      <DashboardNavbar />
      <Link to="paymentsInfo">
        <button>결제 내역</button>
      </Link>
      <Link to="requestAll">
        <button>승인 요청 전체</button>
      </Link>
      <Link to="requestApprove">
        <button>승인</button>
      </Link>
      <Link to="refuse">
        <button>반려</button>
      </Link>
      <Routes>
        <Route path="/" element={<PaymentsInfo />}></Route>
        <Route path="/paymentsInfo" element={<PaymentsInfo />}></Route>
        <Route path="/requestAll" element={<RequestAll />}></Route>
        <Route path="/requestApprove" element={<RequestApprove />}></Route>
        <Route path="/refuse" element={<Refuse />}></Route>
      </Routes>
    </DashboardLayout>
  );
}

export default PaymentsTables;
