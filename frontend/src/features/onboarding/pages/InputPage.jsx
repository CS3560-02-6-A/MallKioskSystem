import { theme } from "../../../styles/theme";
import HeaderBar from "../../../components/ui/HeaderBar";

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
        <HeaderBar leftButton={"Change fit ←"} > 
            <text> Progress Bar</text>
        </HeaderBar>
    </main>
    );
}