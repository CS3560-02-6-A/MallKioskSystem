import { theme } from "../../styles/theme";

export default function SectionPanel({ title, children, style }) {
   return (
      <div
	 style={{
	    background: theme.colors.offWhite,
	    borderRadius: "16px",
	    boxShadow: theme.shadows.dropShadow,
	    padding: "20px 24px",
	    display: "flex",
	    flexDirection: "column",
	    gap: "12px",
	    ...style,
	 }}
      >
	 {title && (
	    <h2
	       style={{
		  fontFamily: theme.fonts.display,
		  fontSize: theme.fontSizes.onboardingTagline,
		  fontWeight: theme.fontWeights.regular,
		  color: theme.colors.text,
		  margin: 0,
	       }}
	    >
	       {title}
	    </h2>
	 )}
	 {children}
      </div>
   );
}
