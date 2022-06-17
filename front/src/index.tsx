import "./index.css";
import "./fonts/Exo2-VariableFont_wght.ttf";

import React from "react";
import ReactDOM from "react-dom/client";

import { App } from "./components/App";

const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLElement,
);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);
