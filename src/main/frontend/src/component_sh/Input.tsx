import React from "react";

interface InputProps {
  propsname: string;
  getResult: (obj: { [key: string]: string }) => void;
  initialValue?: string; // 변경: defaultValue -> initialValue
}

const Input: React.FC<InputProps> = ({
  propsname,
  getResult,
  initialValue, // 변경: defaultValue -> initialValue
}) => {
  const [inputValue, setInputValue] = React.useState(initialValue || ""); // 변경: defaultValue -> initialValue

  React.useEffect(() => {
    setInputValue(initialValue || ""); // 변경: defaultValue -> initialValue
  }, [initialValue]);

  return (
    <input
      name={propsname}
      value={inputValue}
      onChange={(e) => {
        setInputValue(e.target.value);
      }}
      onBlur={() => {
        getResult({ [propsname]: inputValue });
      }}
    />
  );
};

export default Input;
