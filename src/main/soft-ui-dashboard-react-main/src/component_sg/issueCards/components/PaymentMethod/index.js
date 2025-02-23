/**
=========================================================
* Soft UI Dashboard React - v4.0.1
=========================================================

* Product Page: https://www.creative-tim.com/product/soft-ui-dashboard-react
* Copyright 2023 Creative Tim (https://www.creative-tim.com)

Coded by www.creative-tim.com

 =========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
*/

// @mui material components
import Card from "@mui/material/Card";
import Grid from "@mui/material/Grid";
import Icon from "@mui/material/Icon";
import Tooltip from "@mui/material/Tooltip";

// Soft UI Dashboard React components
import SoftBox from "components/SoftBox";
import SoftTypography from "components/SoftTypography";
import SoftButton from "components/SoftButton";

// Soft UI Dashboard React base styles
import borders from "assets/theme/base/borders";

// Images
import masterCardLogo from "assets/images/logos/mastercard.png";
import visaLogo from "assets/images/logos/visa.png";
import Invoices from "component_sg/onboarding/components/Invoices";
import { useState } from "react";
function Modal() {
  return (
    <div className="modal">
      {/* <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <p> 여기는 모달 창</p> */}
      <Invoices />
    </div>
  );
}
function IssueNewCardBtn() {
  const { borderWidth, borderColor } = borders;
  let [modal, setModal] = useState(false);

  return (
    <>
      {
        modal == true ? <Modal /> : null //기계역할
      }
      <Card id="delete-account">
        <SoftBox pt={2} px={2} display="flex" justifyContent="space-between" alignItems="center">
          <SoftTypography variant="h6" fontWeight="medium">
            Payment Method
          </SoftTypography>
          <SoftButton variant="gradient" color="dark" onClick={() => setModal(!modal)}>
            <Icon sx={{ fontWeight: "bold" }}>add</Icon>
            &nbsp; 카드 신규 발급
          </SoftButton>
        </SoftBox>
        <SoftBox p={2}>
          <Grid container spacing={3}>
            <Grid item xs={12} md={6}>
              <SoftBox
                border={`${borderWidth[1]} solid ${borderColor}`}
                borderRadius="lg"
                display="flex"
                justifyContent="space-between"
                alignItems="center"
                p={3}
              >
                <SoftBox
                  component="img"
                  src={masterCardLogo}
                  alt="master card"
                  width="10%"
                  mr={2}
                />
                <SoftTypography variant="h6" fontWeight="medium">
                  ****&nbsp;&nbsp;****&nbsp;&nbsp;****&nbsp;&nbsp;7852
                </SoftTypography>
                <SoftBox ml="auto" lineHeight={0}>
                  <Tooltip title="Edit Card" placement="top">
                    <Icon sx={{ cursor: "pointer" }} fontSize="small">
                      edit
                    </Icon>
                  </Tooltip>
                </SoftBox>
              </SoftBox>
            </Grid>
            <Grid item xs={12} md={6}>
              <SoftBox
                border={`${borderWidth[1]} solid ${borderColor}`}
                borderRadius="lg"
                display="flex"
                justifyContent="space-between"
                alignItems="center"
                p={3}
              >
                <SoftBox component="img" src={visaLogo} alt="master card" width="10%" mr={2} />
                <SoftTypography variant="h6" fontWeight="medium">
                  ****&nbsp;&nbsp;****&nbsp;&nbsp;****&nbsp;&nbsp;5248
                </SoftTypography>
                <SoftBox ml="auto" lineHeight={0}>
                  <Tooltip title="Edit Card" placement="top">
                    <Icon sx={{ cursor: "pointer" }} fontSize="small">
                      edit
                    </Icon>
                  </Tooltip>
                </SoftBox>
              </SoftBox>
            </Grid>
          </Grid>
        </SoftBox>
      </Card>
    </>
  );
}

export default IssueNewCardBtn;
