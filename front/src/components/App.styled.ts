import { styled } from "@mui/material";

import theme from "../theme/light";

export const MainContainer = styled("div")(() => ({
  width: "100%",
  height: "100vh",
  background: theme.palette.test,
}));
