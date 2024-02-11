import DashboardLayout from "examples/LayoutContainers/DashboardLayout";
import DashboardNavbar from "examples/Navbars/DashboardNavbar";
import { Link, Route, Routes } from "react-router-dom";
import RequestToMeData from "./data/requestToMeData";
import RequestToMe from "./display/requestToMe";
import RequestApprove from "./display/requestApprove";
import Refuse from "./display/refuse";

function RecievedRequest() {
  const { columns, rows } = RequestToMeData();

  return (
    <DashboardLayout>
      <DashboardNavbar />
      <Link to="requesetToMe">
        <button>전체</button>
      </Link>
      <Link to="requestApprove">
        <button>승인</button>
      </Link>
      <Link to="refuse">
        <button>반려</button>
      </Link>
      <Routes>
        <Route path="/" element={<RequestToMe />}></Route>
        <Route path="/requesetToMe" element={<RequestToMe />}></Route>
        <Route path="/requestApprove" element={<RequestApprove />}></Route>
        <Route path="/refuse" element={<Refuse />}></Route>
      </Routes>
    </DashboardLayout>
  );
}

export default RecievedRequest;
