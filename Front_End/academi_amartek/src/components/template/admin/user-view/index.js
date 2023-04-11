import Header from "../header";
import Sidebar from "../sidebar";

function UserView() {
	return (
		<div>
			<Header />
			<div style={{ display: "flex" }}>
				<Sidebar />
				test from user
			</div>
		</div>
	);
}

export default UserView;
