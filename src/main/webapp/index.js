// type LatLngLiteral = google.maps.LatLngLiteral;
// type MapOptions = google.maps.MapOptions;


const options = useMemo(
	({
		disableDefaultUI : true,
		clickableIcons : false,
		mapId: "f3947d79eba2c6f",	
	})
);

const loader = new loader({
	apiKey: "AIzaSyCpCVaKxl81vxeIZ7_-bpF7Zj_2x1vZ34s",
	version: "weekly",
});

loader.load().then(async() => {
	const { Map } = await google.maps.importLibrary("maps");
	
	map = new google.maps.Map(document.getElementById("map"), {
		center : {lat: 34.02127561489714, lng: -118.2866354425022},
		zoom : 15,
		mapContainerClassName : "map-container",
		options : {options}
	});
	
});