import React from "react";

interface purList {
  purposeCategory: string;
}

interface SelectProps {
  purList: purList[];
}

const Select: React.FC<SelectProps> = ({ purList }) => {
  return (
    <select>
      {purList.map((purList, index) => (
        <option key={index} value={purList.purposeCategory}>
          {purList.purposeCategory}
          ?????
        </option>
      ))}
    </select>
  );
};

export default Select;
