import { theme } from "../../../styles/theme";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import HeaderBar from "../../../components/ui/HeaderBar";
import ProgressBar from "../../../components/ui/ProgressBar";
import AppButton from "../../../components/ui/AppButton";
import ChoiceCard from "../../../components/ui/ChoiceCard";

export default function OccasionPage() {
    const navigate = useNavigate();
    const [selectedShopper, setSelectedShopper] = useState(null);

  return (
        <main
            style={{
        height: "100vh",
        width: "100%",
        overflow: "scroll",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
            }}
        >
            <HeaderBar>
                <ProgressBar step={2} />
            </HeaderBar>
            <h1
                style={{
                    justifyContent: "center",
                    display: "flex",
                    fontFamily: theme.fonts.display,
                    fontSize: theme.fontSizes.onboardingTitle,
                    fontWeight: theme.fontWeights.regular,
                    lineHeight: theme.lineHeights.tight,
                    color: theme.colors.text,
                }}
            >
                Tell us about your day.
            </h1>
            <p
                style={{
                    justifyContent: "center",
                    display: "flex",
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingTagline,
                    fontWeight: theme.fontWeights.light,
                    lineHeight: theme.lineHeights.normal,
                    color: theme.colors.mutedText,
                }}
            >
                We’ll build an outfit around your plans and weather.
            </p>
            <h1
                style={{
                        justifyContent: "center",
                        display: "flex",
                        fontFamily: theme.fonts.display,
                        fontWeight: theme.fontWeights.regular,
                        lineHeight: theme.lineHeights.tight,
                        color: theme.colors.text,
                        }}>
                            What's the occasion? 
            </h1>

            <section
                style={{
                    padding: "5px",
                    justifyContent: "center",
                    display: "flex",
                }}
            >
                <AppButton
                    disabled={!selectedShopper}
                    onClick={() => selectedShopper ? navigate("/occasion") : null}
                >
                    Continue 
                </AppButton>
            </section>
    </main>
    );
}