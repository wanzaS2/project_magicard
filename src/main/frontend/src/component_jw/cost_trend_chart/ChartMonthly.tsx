import React from 'react';
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js';
import { Line } from 'react-chartjs-2';

// ChartJS 모듈 등록
ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
  );

const ChartMonthly = ()=>{
  // 차트 데이터 설정
  
  // 월별 데이터
  const monthlyData = [1000, 1200, 400, 560, 430, 300, 230, 600, 450, 420, 650, 1300];

  // 누적 데이터 계산
  const accumulatedData = monthlyData.map((sum => value => sum += value)(0));
  
  // 평균 데이터 계산
  const averageValue = monthlyData.reduce((acc, curr) => acc + curr, 0) / monthlyData.length;
  const averageData = new Array(monthlyData.length).fill(averageValue);

 const data = {
    labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    datasets: [
      {
        label: '월별 지출액',
        data: monthlyData,
        fill: false,
        borderColor: 'rgba(255, 159, 64, 1)',
        backgroundColor:'rgba(255, 159, 64, 1)',
    },
    {
        label: '누적 지출액',
        data: accumulatedData,
        fill: false,
        borderColor: 'rgba(75, 192, 192, 1)',
        backgroundColor:'rgba(75, 192, 192, 1)',
    },
    {
        label: '평균 지출액',
        data: averageData,
        fill: false,
        borderColor: 'rgba(255, 99, 132, 1)',
        backgroundColor:'rgba(255, 255, 255, 1)',
        borderDash: [5, 5], // 점선으로 표시
      }
    ],
  };

  // 차트 옵션 설정
  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top' as const,
      },
      title: {
        display: true,
        text: '지출 추이',
      },
    },
    scales: {
        x: {
          grid: {
            display: false, // X축 그리드 라인 숨기기
          },
        },
        y: {
          grid: {
            display: false, // Y축 그리드 라인 숨기기
          }, 
        },
      },
  };

  return (
    <div style={{ width: '1000px' }}>
      <Line data={data} options={options} />
    </div>
    )
}

export default ChartMonthly;