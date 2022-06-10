import { createTheme } from "@mui/material";

declare module "@mui/material/styles" {
  export interface Palette {
    test: string;
  }

  export interface PaletteOptions {
    test?: string;
  }
}

const theme = createTheme({
  palette: {
    test: "linear-gradient(119.45deg, #A771FF 0%, rgba(252, 92, 255, 0.49) 46.87%, rgba(255, 71, 71, 0) 100%)",
  },
});

export default theme;
