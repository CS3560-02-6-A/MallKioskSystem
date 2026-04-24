import { theme } from "../../styles/theme";

export default function ProgressBar({ step = 1 }) {

  return (
    <div
      style={{
        width: "100%",
        height: "clamp(25px, 2.5vw, 30px)",
        display: "grid",
        gridTemplateColumns: "1fr 1fr 1fr",
        gap: "6px",
        borderRadius: theme.radius.pill,
        overflow: "hidden",
        padding: "6px",
      }}
    >
      <div style={{ background: theme.colors.eggplant, borderRadius: "999px 0 0 999px", boxShadow: theme.shadows.dropShadow}} />
      <div style={{ background: step > 1 ? theme.colors.eggplant : theme.colors.palePink, boxShadow: theme.shadows.dropShadow }} />
      <div style={{ background: step > 2 ? theme.colors.eggplant : theme.colors.palePink, borderRadius: "0 999px 999px 0", boxShadow: theme.shadows.dropShadow }} />
    </div>
  );
}
