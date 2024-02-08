import React, { useState } from "react";

interface SelectProps {
  purList: { purposeCategory: string }[];
  initValue?: { purposeCategory: string };
  propsname: string;
  setSelectValue: React.Dispatch<React.SetStateAction<string>>;
}

const Select: React.FC<SelectProps> = ({
  purList,
  initValue,
  propsname,
  setSelectValue,
}) => {
  console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

  return (
    <select
      name={propsname}
      value={initValue?.purposeCategory}
      onChange={(e) => {
        setSelectValue(e.target.value);
      }}
    >
      {purList.map((purList, index) => (
        <option key={index} value={purList.purposeCategory}>
          {purList.purposeCategory}
        </option>
      ))}
    </select>
  );
};

export default Select;
