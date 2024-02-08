/* eslint-disable react/prop-types */
// Soft UI Dashboard React components
import SoftTypography from "components/SoftTypography";

const requestTableData = {
  // const [paymentList, setPaymentList] = useState([]);
  columns: [
    { name: "결제일시", align: "center" },
    { name: "사용처", align: "center" },
    { name: "사용금액", align: "center" },
    { name: "카드번호", align: "center" },
    { name: "문서번호", align: "center" },
    { name: "상태", align: "center" },
    { name: "승인요청", align: "center" },
  ],

  rows: [
    {
      결제일시: (
        <SoftTypography variant="caption" color="secondary" fontWeight="medium">
          23/04/18
        </SoftTypography>
      ),
      사용처: (
        <SoftTypography variant="caption" color="secondary" fontWeight="medium">
          마포곱창타운
        </SoftTypography>
      ),
      사용금액: (
        <SoftTypography variant="caption" color="secondary" fontWeight="medium">
          39000
        </SoftTypography>
      ),
      카드번호: (
        <SoftTypography variant="caption" color="secondary" fontWeight="medium">
          1111-2222-3333-4444
        </SoftTypography>
      ),
      문서번호: (
        <SoftTypography
          component="a"
          href="#"
          variant="caption"
          color="secondary"
          fontWeight="medium"
        >
          1111-1111
        </SoftTypography>
      ),
      상태: (
        <SoftTypography variant="caption" color="secondary" fontWeight="medium">
          1차 승인
        </SoftTypography>
      ),
      승인요청: (
        <SoftTypography
          component="a"
          href="#"
          variant="caption"
          color="secondary"
          fontWeight="medium"
        >
          승인 요청
        </SoftTypography>
      ),
    },
  ],
};

export default requestTableData;
