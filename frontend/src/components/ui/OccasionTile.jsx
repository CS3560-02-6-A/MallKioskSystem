import { useState } from "react";
import { theme } from "../../styles/theme";

export default function OccasionTile({ options = [], onSelect, style = {} }) {
  const [selectedIndex, setSelectedIndex] = useState(null);

  const handleSelect = (index) => {
    setSelectedIndex(index);
    if (onSelect) onSelect(options[index], index);
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        gap: "32px",
        ...style,
      }}
    >
      {options.map((label, index) => {
        const isSelected = selectedIndex === index;
        return (
          <button
            key={index}
            type="button"
            aria-pressed={isSelected}
            onClick={() => handleSelect(index)}
            style={{
              display: "flex",
              alignItems: "stretch",
              width: "100%",
              border: `2px solid ${theme.colors.lightBrown}`,
              borderRadius: "8px",
              background: isSelected ? theme.colors.tan : theme.colors.palePink,
              cursor: "pointer",
              padding: 0,
              overflow: "hidden",
              transition: "background 120ms ease",
              fontFamily: theme.fonts.sans,
              color: theme.colors.text,
              boxShadow: theme.shadows.dropShadow,
            }}
          >
            <span
              style={{
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                minWidth: "48px",
                padding: "16px 14px",
                borderRight: `1.5px solid ${theme.colors.lightBrown}`,
                fontWeight: theme.fontWeights.bold,
                fontSize: theme.fontSizes.onboardingTagline,
                background: theme.colors.offWhite,
                transition: "background 120ms ease",
                flexShrink: 0,
              }}
            >
              {index + 1}
            </span>
            <span
              style={{
                display: "flex",
                alignItems: "center",
                padding: "16px 20px",
                fontFamily: theme.fonts.sans,
                fontSize: theme.fontSizes.cta,
                fontWeight: isSelected ? theme.fontWeights.bold : theme.fontWeights.regular,
                textAlign: "left",
              }}
            >
              {label}
            </span>
          </button>
        );
      })}
    </div>
  );
}
