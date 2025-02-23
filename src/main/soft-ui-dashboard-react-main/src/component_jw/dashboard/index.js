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
import Grid from "@mui/material/Grid";
import Icon from "@mui/material/Icon";
import Card from "@mui/material/Card";

// Soft UI Dashboard React components
import SoftBox from "components/SoftBox";
import SoftTypography from "components/SoftTypography";

// Soft UI Dashboard React examples
import DashboardLayout from "examples/LayoutContainers/DashboardLayout";
import DashboardNavbar from "examples/Navbars/DashboardNavbar";
import Footer from "examples/Footer";
import MiniStatisticsCard from "examples/Cards/StatisticsCards/MiniStatisticsCard";
import ReportsBarChart from "examples/Charts/BarCharts/ReportsBarChart";
import GradientLineChart from "examples/Charts/LineCharts/GradientLineChart";

// Soft UI Dashboard React base styles
import typography from "assets/theme/base/typography";

// Dashboard layout components
import BuildByDevelopers from "layouts/dashboard/components/BuildByDevelopers";
import WorkWithTheRockets from "layouts/dashboard/components/WorkWithTheRockets";
import Projects from "layouts/dashboard/components/Projects";
import OrderOverview from "layouts/dashboard/components/OrderOverview";

// Data
import reportsBarChartData from "layouts/dashboard/data/reportsBarChartData";
import gradientLineChartData from "layouts/dashboard/data/gradientLineChartData";
import LineChart from "component_jw/cost_trend_chart/LineChart";
import BarChart from "component_jw/department_chart/BarChart";
import DoughnutChart from "component_jw/purpose_chart/DoughnutChart";
import TotalCards from "component_jw/basic_information/TotalCards";
import TotalUses from "component_jw/basic_information/TotalUses";
import TotalPayment from "component_jw/basic_information/TotalPayment";
import Totalapproval from "component_jw/basic_information/TotalApproval";

function Dashboard() {
  const { size } = typography;
  const { chart, items } = reportsBarChartData;

  return (
    <DashboardLayout>
      <DashboardNavbar />
        
      
      <SoftBox py={3}>
        <SoftBox mb={3}>
          <Grid container spacing={3}>
            <Grid item xs={12} sm={6} xl={3}>
              <TotalCards/>
            </Grid>
            <Grid item xs={12} sm={6} xl={3}>
              <TotalUses/>
            </Grid>
            <Grid item xs={12} sm={6} xl={3}>
              <TotalPayment/>
            </Grid>
            <Grid item xs={12} sm={6} xl={3}>
              <Totalapproval/>
            </Grid>
          </Grid>
        </SoftBox>
        
        <SoftBox mb={3}>
         <Card >
          <Grid container spacing={3} style={{
            display: 'flex',
            justifyContent: 'center',
            padding:'1.25rem'
          }}>
                <Grid item xs={12} lg={10} >
                  <LineChart/>
                </Grid>
              </Grid>
            </Card>
            </SoftBox>
            <SoftBox mb={3} >
      
       
              <Grid  container spacing={3}  >
                <Grid item xs={7.75} >
                  <Card >
                    <SoftBox >
                      <BarChart/>
                    </SoftBox>
                  </Card >
                </Grid>

                <Grid item xs={4.25}>
                  <Card>
                    <SoftBox style={{padding:'1.25rem'}}>
                      <DoughnutChart />
                    </SoftBox>
                  </Card>
                </Grid>
              </Grid>
             
      
       </SoftBox>

        
       
        <SoftBox mb={3}>
          <Grid container spacing={3}>
            <Grid item xs={12} lg={7}>
              <BuildByDevelopers />
            </Grid>
            <Grid item xs={12} lg={5}>
              <WorkWithTheRockets />
            </Grid>
          </Grid>
        </SoftBox>

       

        <SoftBox mb={3}>
          <Grid container spacing={3}>
            <Grid item xs={12} lg={5}>
              <ReportsBarChart
                title="active users"
                description={
                  <>
                    (<strong>+23%</strong>) than last week
                  </>
                }
                chart={chart}
                items={items}
              />
            </Grid>
            <Grid item xs={12} lg={7}>
              <GradientLineChart
                title="Sales Overview"
                description={
                  <SoftBox display="flex" alignItems="center">
                    <SoftBox fontSize={size.lg} color="success" mb={0.3} mr={0.5} lineHeight={0}>
                      <Icon className="font-bold">arrow_upward</Icon>
                    </SoftBox>
                    <SoftTypography variant="button" color="text" fontWeight="medium">
                      4% more{" "}
                      <SoftTypography variant="button" color="text" fontWeight="regular">
                        in 2021
                      </SoftTypography>
                    </SoftTypography>
                  </SoftBox>
                }
                height="20.25rem"
                chart={gradientLineChartData}
              />
            </Grid>
          </Grid>
        </SoftBox>
        <Grid container spacing={3}>
          <Grid item xs={12} md={6} lg={8}>
            <Projects />
          </Grid>
          <Grid item xs={12} md={6} lg={4}>
            <OrderOverview />
          </Grid>
        </Grid>
      </SoftBox>
      <Footer />
    </DashboardLayout>
  );
}

export default Dashboard;
