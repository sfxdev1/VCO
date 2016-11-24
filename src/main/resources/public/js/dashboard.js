var userObj
window.addEventListener('load', function () {
  firebase.auth().onAuthStateChanged(function (user) {
    if (user) {
      // User is signed in.
      var displayName = user.displayName
      var email = user.email
      var emailVerified = user.emailVerified
      var photoURL = user.photoURL
      var uid = user.uid
      var providerData = user.providerData
      user.getToken().then(function (accessToken) {
        userObj = user
        initBaseGui(displayName, email, emailVerified, photoURL, uid, providerData)
      })
    } else {
      // User is signed out.
      failedToLoad()
    }
  }, function (error) {
    console.log(error)
  })
})
var initBaseGui = function (name, email, emailVerified, photoURL, uid, providerData) {
  document.getElementById('user').setAttribute('src', photoURL)
  document.getElementById('name').textContent = name
  document.getElementById('email').textContent = email
}
var failedToLoad = function () {
  window.location.assign('/')
}
