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
        minHeight: "clamp(88px, 12vh, 100px)",
        display: "flex",
        alignItems: "center",
        justifyContent: "space-between",
        padding: "clamp(16px, 2vw, 24px)",
        border: `1px solid ${theme.colors.text}`,
        background: "transparent",
        gap: "clamp(10px, 4vw, 65px)",
      }}>
      <GoBackButton> {leftButton} </GoBackButton>
      <div style={{ flex: 1 }}>{children}</div>
      <EndSessionButton/>
    </header>
  );
}
