import { styled } from "@mui/material";

export const MainContainer = styled("div")(({ theme }) => ({
  width: "100%",
  height: "100vh",
  background: theme.palette.primary.main,
}));
