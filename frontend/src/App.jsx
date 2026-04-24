import OnboardingPage from "./features/onboarding/pages/OnboardingPage";
import InputPage from "./features/onboarding/pages/InputPage";
import OccasionPage from "./features/outfit-curator/pages/OccasionPage";
import { Navigate, Route, Routes } from "react-router-dom";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<OnboardingPage />} /> {/* Default route */}
      <Route path="/onboarding" element={<OnboardingPage />} />
      <Route path="/input" element={<InputPage />} />
      <Route path="/occasion" element={<OccasionPage />} />
      <Route path="*" element={<Navigate to="/onboarding" replace />} />

      {/* <Route path="/gender" element={<GenderPage />} />
      
      <Route path="/outfit" element={<OutfitBuilderPage />} /> */}
    </Routes>
  );
}