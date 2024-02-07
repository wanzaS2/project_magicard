import React, { useState } from "react";
import ChartMonthly from "./ChartMonthly";
import ChartQuarterly from "./ChartQuarterly";
import ChartYearly from "./ChartYearly";

interface SelectOptionProps {
    onChange: (event: React.ChangeEvent<HTMLSelectElement>) => void;
}

function LineChart(props: any) { // 여기서 props의 타입을 any 대신 더 구체적으로 정의할 수 있습니다.
  const [select, setSelect] = useState<number>(1); // 상태의 타입을 number로 명시
  const onChange = (e: React.ChangeEvent<HTMLSelectElement>) => { // 이벤트 객체의 타입을 명시
    console.log(e.target.value);
    setSelect(parseInt(e.target.value, 10)); // e.target.value는 string이므로 number로 변환
  };
  return (
    <div>
      <SelectOption onChange={onChange}></SelectOption>
      {select === 1 ? <Monthly /> : select === 2 ? <Quarterly /> : <Yearly />}
    </div>
  );
}
function Quarterly() {
    return <div><ChartQuarterly/></div>;
}
function Yearly() {
    return <div><ChartYearly/></div>;
}
function Monthly() {    
    return <div><ChartMonthly/></div>;
}
function SelectOption({ onChange }:SelectOptionProps) {
    return (
      <div>
        <select onChange={onChange}>
          <option value={1}>월별</option>
          <option value={2}>분기별</option>
          <option value={3}>연도별</option>
        </select>
      </div>
    );
}


export default LineChart;