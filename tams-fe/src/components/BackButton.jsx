import { Link } from "react-router-dom";

function BackButton({ url, buttonName }) {
  return (
    <Link to={url} className="btn btn-back">
      {buttonName}
    </Link>
  );
}

export default BackButton;
