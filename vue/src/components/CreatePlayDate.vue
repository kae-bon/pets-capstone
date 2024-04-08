<template>
    <div>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="playDateModal">Create Play Date</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="title" placeholder="title">
                            <label for="title">Title</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="description" placeholder="description">
                            <label for="description">Description</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="datetime-local" class="form-control" id="date" placeholder="date">
                            <label for="date">Date & Time</label>
                        </div>
                        <div class="form-floating">
                            <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                <option selected>---</option>
                                <option value="1">placeholder</option>
                                <option value="2">placeholder2</option>
                                <option value="3">placeholder3</option>
                            </select>
                            <label for="floatingSelect">Select a Location</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                                checked>
                            <label class="form-check-label" for="flexRadioDefault1">
                                Public
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                                checked>
                            <label class="form-check-label" for="flexRadioDefault1">
                                Private
                            </label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped></style>