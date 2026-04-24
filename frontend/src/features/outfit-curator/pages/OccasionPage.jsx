import React from 'react';
import GoBackButton from "../../../components/ui/GoBackButton";
import EndSessionButton from "../../../components/ui/EndSessionButton";
import AppButton from "../../../components/ui/AppButton";

export default function OccasionPage({InputPage}){
    return(
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
                    nClick={() => setShowInputPage(false)}
                >
                ← Go Back
                </GoBackButton>
                <EndSessionButton>
                    End Session
                </EndSessionButton>
            </section>
            <section>
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
                        We will build an outfit based on your plans.
                </p>
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
                    What is the ocassion?
                </h1>
            </section>
            <section>
                <button>Formal</button>
                <button>Work</button>
                <button>Casual</button>
            </section>
            <section
                style={{
                    padding: "5px",
                    ustifyContent: "center",
                    display: "flex",
                }}
            >
                <AppButton>
                    Continue
                </AppButton>
            </section>
        </main>
    );
}