import { ThemeProvider } from "@mui/material";
import { FC } from "react";

import theme from "../theme/light";
import { MainContainer } from "./App.styled";

export const App: FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <MainContainer>
        <div>hello</div>
      </MainContainer>
    </ThemeProvider>
  );
};
