import { theme } from "../../../styles/theme";
import GoBackButton from "../../../components/ui/GoBackButton";
import EndSessionButton from "../../../components/ui/EndSessionButton";

export default function InputPage({ setShowInputPage }) {
  return (
    <main
    style={{
        height: "100vh",
        width: "100%",
        overflow: "hidden",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
    }}
>
            <section
                style={{
                    width: "100%",
                    minHeight: "clamp(88px, 12vh, 100px)",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "space-between",
                    padding: "clamp(16px, 2vw, 24px)",
                    border: `1px solid ${theme.colors.text}`,
                    background: "transparent",
                }}
            >
                <GoBackButton
                    onClick={() => setShowInputPage(false)}
                    >
                    ← Go Back
                </GoBackButton>
                <EndSessionButton>
                    End Session
                </EndSessionButton>
        
            </section>
    </main>
    );
}