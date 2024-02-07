import React, { useState } from "react";

const CardApplicationForm: React.FC = () => {
  const [selectedCardType, setSelectedCardType] = useState<string>("");

  const handleCardTypeChange = (cardType: string) => {
    setSelectedCardType(cardType);
  };

  const handlePrevious = () => {
    // Handle previous button click
  };

  const handleNext = () => {
    // Handle next button click
  };

  return (
    <img
      src="/static/image/issueCard.png"
      alt="issue card img"
      width="auto"
      height="auto"
    />
    // <div>
    //   <h1>카드 발급 신청</h1>
    //   <img src="path/to/image" alt="카드 이미지" />
    //   <h2>카드 선택 및 설정</h2>
    //   <div>
    //     <h3>카드 유형</h3>
    //     <div>
    //       <label>
    //         <input
    //           type="checkbox"
    //           checked={selectedCardType === "cardType1"}
    //           onChange={() => handleCardTypeChange("cardType1")}
    //         />
    //         카드 이미지 1
    //       </label>
    //     </div>
    //     <div>
    //       <label>
    //         <input
    //           type="checkbox"
    //           checked={selectedCardType === "cardType2"}
    //           onChange={() => handleCardTypeChange("cardType2")}
    //         />
    //         카드 이미지 2
    //       </label>
    //     </div>
    //     <div>
    //       <label>
    //         <input
    //           type="checkbox"
    //           checked={selectedCardType === "cardType3"}
    //           onChange={() => handleCardTypeChange("cardType3")}
    //         />
    //         카드 이미지 3
    //       </label>
    //     </div>
    //   </div>
    //   {selectedCardType && (
    //     <div>
    //       <h3>카드 혜택 선택</h3>
    //       <div>
    //         <label>
    //           <input type="checkbox" />
    //           카드 혜택 1
    //         </label>
    //       </div>
    //       <div>
    //         <label>
    //           <input type="checkbox" />
    //           카드 혜택 2
    //         </label>
    //       </div>
    //       <div>
    //         <label>
    //           <input type="checkbox" />
    //           카드 혜택 3
    //         </label>
    //       </div>
    //       <div>
    //         <label>
    //           <input type="checkbox" />
    //           카드 혜택 4
    //         </label>
    //       </div>
    //       <div>
    //         <label>
    //           <input type="checkbox" />
    //           카드 혜택 5
    //         </label>
    //       </div>
    //     </div>
    //   )}
    //   <button onClick={handlePrevious}>이전</button>
    //   <button onClick={handleNext}>다음</button>
    // </div>
  );
};

export default CardApplicationForm;
