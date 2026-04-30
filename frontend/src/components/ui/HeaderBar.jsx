import { theme } from "../../styles/theme";
import GoBackButton from "./GoBackButton";
import EndSessionButton from "./EndSessionButton";


export default function HeaderBar({ 
  children, 
  leftButton = "← Go Back",
  style = {}, 
  ...props 
}) {
  return (
    <header style={{ 
        width: "100%",
        height: "clamp(88px, 14vh, 120px)",
        display: "flex",
        alignItems: "center",
        justifyContent: "space-between",
        padding: "clamp(16px, 2vw, 24px)",
        background: "transparent",
        gap: "clamp(10px, 4vw, 65px)",
      }}>
      <GoBackButton> {leftButton} </GoBackButton>
      <div style={{ flex: 1 }}>{children}</div>
      <EndSessionButton/>
    </header>
  );
}
