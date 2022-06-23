import { createTheme } from "@mui/material";

export enum COLOR {
  RED = "RED",
  GREEN = "GREEN",
  INPUT_BORDER = "INPUT_BORDER",
  INPUT_BORDER_LIGHT = "INPUT_BORDER_LIGHT",
  BUTTON_BORDER = "BUTTON_BORDER",
  DEFAULT = "DEFAULT",
  TRANSPARENT = "TRANSPARENT",
}

declare module "@mui/material/styles" {
  export interface Palette {
    widget: {
      background: string;
      border: string;
    };
    border: {
      main: string;
      light: string;
    };
    button: {
      background: string;
      color: string;
      hover: string;
      border: string;
    };
    input: {
      background: string;
      border: string;
      borderLight: string;
    };
  }

  export interface PaletteOptions {
    widget?: {
      background?: string;
      border?: string;
    };
    border?: {
      main?: string;
      light?: string;
    };
    button?: {
      background?: string;
      color?: string;
      hover?: string;
      border?: string;
    };
    input?: {
      background?: string;
      border?: string;
      borderLight?: string;
    };
  }

  export interface Mixins {
    button: {
      boxShadow: string;
    };
    rateColor: (color?: COLOR) => string;
  }

  export interface MixinsOptions {
    button?: {
      boxShadow?: string;
    };
    rateColor?: (color?: COLOR) => string;
  }
}

const theme = createTheme({
  palette: {
    primary: {
      main: "#fff",
    },
    success: {
      main: "#219653",
    },
    error: {
      main: "#EB5757",
    },
    warning: {
      main: "#F2994A",
    },
    widget: {
      background: "#fff",
      border: "#DBDBDB",
    },
    border: {
      main: "#F5F5F5",
      light: "#fff",
    },
    button: {
      background: "#101010",
      color: "#FFF",
      hover: "#f5f5f5",
      border: "rgba(97, 97, 97, .3)",
    },
    input: {
      background: "#FAFAFA",
      border: "rgba(97, 97, 97, .6)",
      borderLight: "rgba(97, 97, 97, .1)",
    },
    text: {
      primary: "#212121",
      secondary: "#616161",
    },
  },
  typography: {
    fontFamily: "'Exo 2', sans-serif",
  },
  mixins: {
    button: {
      boxShadow: "4px 8px 24px rgba(16, 16, 16, 0.25)",
    },
    rateColor: (color?: COLOR) => {
      switch (color) {
        case COLOR.GREEN:
          return theme.palette.success.main;
        case COLOR.RED:
          return theme.palette.error.main;
        case COLOR.INPUT_BORDER:
          return theme.palette.input.border;
        case COLOR.INPUT_BORDER_LIGHT:
          return theme.palette.input.borderLight;
        case COLOR.BUTTON_BORDER:
          return theme.palette.button.border;
        case COLOR.TRANSPARENT:
          return "transparent";
        default:
          return "inherit";
      }
    },
  },
});

export default theme;
