<template>
    <div>
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="playDateModal">Create Play Date</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="title" placeholder="title" maxlength="100"
                                v-model="newPlayDate.title">
                            <label for="title">Title</label>
                        </div>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" id="description" placeholder="description" maxlength="300"
                                v-model="newPlayDate.description">
                                </textarea>
                            <label for="description">Description</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="datetime-local" class="form-control" id="date" placeholder="date"
                                v-model="newPlayDate.dateTime">
                            <label for="date">Date & Time</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                                v-model="newPlayDate.location">
                                <option selected>---</option>
                                <option value="1">placeholder</option>
                                <option value="2">placeholder2</option>
                                <option value="3">placeholder3</option>
                            </select>
                            <label for="floatingSelect">Select a Location</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="true" name="flexRadioDefault"
                                id="radiopublic" v-model="newPlayDate.isPublic" checked>
                            <label class="form-check-label" for="radiopublic">
                                Public - anyone can join!
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="false" name="flexRadioDefault"
                                id="radioprivate" v-model="newPlayDate.isPublic">
                            <label class="form-check-label" for="radioprivate">
                                Private - you approve who comes!
                            </label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Create Play Date</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            newPlayDate: {
                title: "",
                description: "",
                dateTime: "",
                location: "",
                isPublic: true
            }
        }
    }
}
</script>

<style scoped>
.modal-footer {
    justify-content: space-between;
}

#description {
    height: 175px;
}
</style>