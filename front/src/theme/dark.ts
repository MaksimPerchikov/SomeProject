import { createTheme } from "@mui/material";

import main from "./main";

const theme = createTheme({
  ...main,
  palette: {
    primary: {
      main: "#191D20",
    },
    widget: {
      background: "#272A2F",
    },
    button: {
      background: "#FAFAFA",
      color: "#212121",
    },
    input: {
      background: "#1F222A",
      border: "#FFF",
    },
    text: {
      primary: "#FFF",
      secondary: "#E0E0E0",
    },
  },
  mixins: {
    button: {
      boxShadow: "none",
    },
  },
});

export default theme;
