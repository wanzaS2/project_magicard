import React from "react";
import styles from "./OnboardingVideo.module.css";
import { useNavigate } from "react-router";

const OnboardingVideo: React.FC = () => {
  const navigate = useNavigate();
  const handlePrevious = () => {
    // Handle previous button click
  };

  const handleNext = () => {
    navigate("/welcome");
  };

  return (
    <>
      <div className={styles.container}>
        <div className={styles.content}>
          <h1 className={styles.title}>회원가입</h1>
          <div className={styles.videoContainer}>
            <div className={styles.directionTextBox}>
              <img
                src="/static/image/use_direction.png"
                alt="법인 카드 사용 설명"
              />
              <p>
                동영상을 통해 알려드리는 내용은 카드 사용에 대한 지침 및 보안
                조치, 리워드 프로그램, 그리고 중요한 약관사항 등 다양한 정보를
                포함하고 있습니다. <br />
                이는 당사의 서비스를 안전하게 이용하고, 카드를 효과적으로 활용
                사실 수 있도록 도움을 드리고자 함입니다.
              </p>
            </div>
            <div className={styles.videoFrame}>
              <iframe
                width="560"
                height="315"
                src="https://www.youtube.com/embed/D5AfLb_Zpzs?si=tDH2kfpbMzwk-6rJ"
                title="법인 카드 사용 안내"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowFullScreen
              ></iframe>
            </div>
          </div>
          <div className={styles.agreementContainer}>
            <img
              className={styles.useAgreement}
              alt="법인 카드 약관 동의"
              src="/static/image/use_agreement.png"
              object-fit="none"
            />
            <div className={styles.documents}>
              <div>
                <a
                  href="https://download.blog.naver.com/open/20b53c8f98c5c41835d2b483b650255ff9a156b142/6Z0Z7iAvyKxJpPmQBqjcFout0Rip5bIGdPajrR2lXNCVowCx8kWvfixIU1Ej1WYH6cZ8V6u4NAaQmRwy1aFwrg/%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC%EA%B8%B0%EC%82%AC%20%ED%95%84%EA%B8%B0%20%EC%A0%95%EB%A6%AC%EB%B3%B8.pdf"
                  download
                >
                  🧾약관 동의 서약서 A
                </a>
              </div>
              <div>
                <a
                  href="https://download.blog.naver.com/open/20b53c8f98c5c41835d2b483b650255ff9a156b142/6Z0Z7iAvyKxJpPmQBqjcFout0Rip5bIGdPajrR2lXNCVowCx8kWvfixIU1Ej1WYH6cZ8V6u4NAaQmRwy1aFwrg/%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC%EA%B8%B0%EC%82%AC%20%ED%95%84%EA%B8%B0%20%EC%A0%95%EB%A6%AC%EB%B3%B8.pdf"
                  download
                >
                  🧾약관 동의 서약서 B
                </a>
              </div>
              <div>
                <a
                  href="https://download.blog.naver.com/open/20b53c8f98c5c41835d2b483b650255ff9a156b142/6Z0Z7iAvyKxJpPmQBqjcFout0Rip5bIGdPajrR2lXNCVowCx8kWvfixIU1Ej1WYH6cZ8V6u4NAaQmRwy1aFwrg/%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC%EA%B8%B0%EC%82%AC%20%ED%95%84%EA%B8%B0%20%EC%A0%95%EB%A6%AC%EB%B3%B8.pdf"
                  download
                >
                  🧾약관 동의 서약서 C
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <button onClick={handlePrevious}>이전</button>
      <button onClick={handleNext}>다음</button>
    </>
  );
};

export default OnboardingVideo;
