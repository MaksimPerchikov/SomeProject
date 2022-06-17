import { ThemeProvider } from "@mui/material";
import { FC } from "react";

import main from "../theme/main";
import { MainContainer } from "./App.styled";
import { Auth } from "./pages/Auth/Auth";

export const App: FC = () => {
  return (
    <ThemeProvider theme={main}>
      <MainContainer>
        <Auth />
      </MainContainer>
    </ThemeProvider>
  );
};
